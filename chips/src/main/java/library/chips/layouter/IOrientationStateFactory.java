package library.chips.layouter;


import androidx.recyclerview.widget.RecyclerView;

import library.chips.gravity.IRowStrategyFactory;
import library.chips.layouter.breaker.IBreakerFactory;
import library.chips.layouter.breaker.IRowBreaker;
import library.chips.layouter.criteria.ICriteriaFactory;
import library.chips.layouter.placer.IPlacerFactory;

interface IOrientationStateFactory {
    ILayouterCreator createLayouterCreator(RecyclerView.LayoutManager lm);
    IRowStrategyFactory createRowStrategyFactory();
    IBreakerFactory createDefaultBreaker();
}
