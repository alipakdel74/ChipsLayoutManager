package library.chips.layouter;

import android.view.View;

import library.chips.ChipsLayoutManager;
import library.chips.IScrollingController;
import library.chips.anchor.AnchorViewState;
import library.chips.anchor.ColumnsAnchorFactory;
import library.chips.anchor.IAnchorFactory;
import library.chips.cache.IViewCacheStorage;
import library.chips.gravity.ColumnGravityModifiersFactory;
import library.chips.gravity.ColumnStrategyFactory;
import library.chips.gravity.IRowStrategyFactory;
import library.chips.layouter.breaker.DecoratorBreakerFactory;
import library.chips.layouter.breaker.ColumnBreakerFactory;
import library.chips.layouter.criteria.AbstractCriteriaFactory;
import library.chips.layouter.criteria.ColumnsCriteriaFactory;
import library.chips.layouter.criteria.ICriteriaFactory;
import library.chips.layouter.criteria.InfiniteCriteriaFactory;
import library.chips.layouter.placer.IPlacerFactory;
import library.chips.util.StateHelper;

public class ColumnsStateFactory implements IStateFactory {

    private ChipsLayoutManager lm;
    private IRowStrategyFactory rowStrategyFactory;

    public ColumnsStateFactory(ChipsLayoutManager lm) {
        this.lm = lm;
        rowStrategyFactory = new ColumnStrategyFactory();
    }

    @Override
    public LayouterFactory createLayouterFactory(ICriteriaFactory criteriaFactory, IPlacerFactory placerFactory) {
        IViewCacheStorage cacheStorage = lm.getViewPositionsStorage();

        return createColumnLayouterFactory(criteriaFactory, placerFactory, cacheStorage);
    }

    private LayouterFactory createColumnLayouterFactory(ICriteriaFactory criteriaFactory, IPlacerFactory placerFactory, IViewCacheStorage cacheStorage) {
         return new LayouterFactory(lm,
                 new ColumnsCreator(lm),
                 new DecoratorBreakerFactory(cacheStorage, lm.getRowBreaker(), lm.getMaxViewsInRow(), new ColumnBreakerFactory()),
                 criteriaFactory,
                 placerFactory,
                 new ColumnGravityModifiersFactory(),
                 rowStrategyFactory.createRowStrategy(lm.getRowStrategyType()));
    }

    @Override
    public AbstractCriteriaFactory createDefaultFinishingCriteriaFactory() {
        return StateHelper.isInfinite(this)? new InfiniteCriteriaFactory() : new ColumnsCriteriaFactory();
    }

    @Override
    public IAnchorFactory anchorFactory() {
        return new ColumnsAnchorFactory(lm, lm.getCanvas());
    }

    @Override
    public IScrollingController scrollingController() {
        return lm.horizontalScrollingController();
    }

    @Override
    public ICanvas createCanvas() {
        return new ColumnSquare(lm);
    }

    @Override
    public int getSizeMode() {
        return lm.getWidthMode();
    }

    @Override
    public int getStart() {
        return 0;
    }

    @Override
    public int getStart(View view) {
        return lm.getDecoratedLeft(view);
    }

    @Override
    public int getStart(AnchorViewState anchor) {
        return anchor.getAnchorViewRect().left;
    }

    @Override
    public int getEnd() {
        return lm.getWidth();
    }

    @Override
    public int getEnd(View view) {
        return lm.getDecoratedRight(view);
    }

    @Override
    public int getEnd(AnchorViewState anchor) {
        return anchor.getAnchorViewRect().right;
    }

    @Override
    public int getEndViewPosition() {
        return lm.getPosition(lm.getCanvas().getBottomView());
    }

    @Override
    public int getStartAfterPadding() {
        return lm.getPaddingLeft();
    }

    @Override
    public int getStartViewPosition() {
        return lm.getPosition(lm.getCanvas().getTopView());
    }

    @Override
    public int getEndAfterPadding() {
        return lm.getWidth() - lm.getPaddingRight();
    }

    @Override
    public int getStartViewBound() {
        return getStart(lm.getCanvas().getLeftView());
    }

    @Override
    public int getEndViewBound() {
        return getEnd(lm.getCanvas().getRightView());
    }

    @Override
    public int getTotalSpace() {
        return lm.getWidth() - lm.getPaddingLeft()
                - lm.getPaddingRight();
    }


}
