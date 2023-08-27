package library.chips.layouter;


import androidx.recyclerview.widget.RecyclerView;

import library.chips.gravity.IRowStrategyFactory;
import library.chips.gravity.LTRRowStrategyFactory;
import library.chips.layouter.breaker.IBreakerFactory;
import library.chips.layouter.breaker.LTRRowBreakerFactory;

class LTRRowsOrientationStateFactory implements IOrientationStateFactory {

    @Override
    public ILayouterCreator createLayouterCreator(RecyclerView.LayoutManager lm) {
        return new LTRRowsCreator(lm);
    }

    @Override
    public IRowStrategyFactory createRowStrategyFactory() {
        return new LTRRowStrategyFactory();
    }

    @Override
    public IBreakerFactory createDefaultBreaker() {
        return new LTRRowBreakerFactory();
    }
}
