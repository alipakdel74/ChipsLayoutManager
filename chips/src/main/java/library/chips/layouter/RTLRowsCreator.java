package library.chips.layouter;

import android.graphics.Rect;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import library.chips.ChipsLayoutManager;
import library.chips.anchor.AnchorViewState;
import library.chips.gravity.IGravityModifiersFactory;
import library.chips.gravity.IRowStrategy;
import library.chips.layouter.breaker.IBreakerFactory;
import library.chips.cache.IViewCacheStorage;
import library.chips.layouter.criteria.ICriteriaFactory;
import library.chips.layouter.placer.IPlacerFactory;

class RTLRowsCreator implements ILayouterCreator {

    private RecyclerView.LayoutManager layoutManager;

    RTLRowsCreator(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    //---- up layouter below
    @Override
    public Rect createOffsetRectForBackwardLayouter(@NonNull AnchorViewState anchor) {
        Rect anchorRect = anchor.getAnchorViewRect();

        return new Rect(
                //we shouldn't include anchor view here, so anchorLeft is a rightOffset
                anchorRect == null ? 0 : anchorRect.right,
                anchorRect == null ? 0 : anchorRect.top,
                0,
                anchorRect == null ? 0 : anchorRect.bottom);
    }

    @Override
    public AbstractLayouter.Builder createBackwardBuilder() {
        return RTLUpLayouter.newBuilder();
    }

    //---- down layouter below

    @Override
    public AbstractLayouter.Builder createForwardBuilder() {
        return RTLDownLayouter.newBuilder();
    }

    @Override
    public Rect createOffsetRectForForwardLayouter(AnchorViewState anchor) {
        Rect anchorRect = anchor.getAnchorViewRect();

        return new Rect(
                0,
                anchorRect == null ? anchor.getPosition() == 0 ? layoutManager.getPaddingTop() : 0 : anchorRect.top,
                anchorRect == null ? layoutManager.getPaddingRight() : anchorRect.right,
                anchorRect == null ? anchor.getPosition() == 0 ? layoutManager.getPaddingBottom() : 0 : anchorRect.bottom);
    }
}
