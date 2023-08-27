package library.chips.layouter;


import androidx.recyclerview.widget.RecyclerView;

import library.chips.gravity.IRowStrategyFactory;
import library.chips.gravity.RTLRowStrategyFactory;
import library.chips.layouter.breaker.IBreakerFactory;
import library.chips.layouter.breaker.RTLRowBreakerFactory;

class RTLRowsOrientationStateFactory implements IOrientationStateFactory {

    @Override
    public ILayouterCreator createLayouterCreator(RecyclerView.LayoutManager lm) {
        return new RTLRowsCreator(lm);
    }

    @Override
    public IRowStrategyFactory createRowStrategyFactory() {
        return new RTLRowStrategyFactory();
    }

    @Override
    public IBreakerFactory createDefaultBreaker() {
        return new RTLRowBreakerFactory();
    }
}
