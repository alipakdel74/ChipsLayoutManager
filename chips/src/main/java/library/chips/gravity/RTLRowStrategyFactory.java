package library.chips.gravity;

import library.chips.ChipsLayoutManager;
import library.chips.RowStrategy;

public class RTLRowStrategyFactory implements IRowStrategyFactory {

    @Override
    public IRowStrategy createRowStrategy(@RowStrategy int rowStrategy) {
        switch (rowStrategy) {
            case ChipsLayoutManager.STRATEGY_CENTER:
                return new RTLRowFillSpaceCenterStrategy();
            case ChipsLayoutManager.STRATEGY_FILL_SPACE:
                return new RTLRowFillSpaceStrategy();
            case ChipsLayoutManager.STRATEGY_FILL_VIEW:
                return new RTLRowFillStrategy();
            case ChipsLayoutManager.STRATEGY_CENTER_DENSE:
                return new RTLRowFillSpaceCenterDenseStrategy();
            case ChipsLayoutManager.STRATEGY_DEFAULT:
            default:
                return new EmptyRowStrategy();
        }
    }
}
