package library.chips.layouter.breaker;

import library.chips.layouter.AbstractLayouter;

/** this is basis row breaker for {@link library.chips.layouter.LTRUpLayouter} */
class LTRBackwardRowBreaker implements ILayoutRowBreaker {
    @Override
    public boolean isRowBroke(AbstractLayouter al) {
        return al.getViewRight() - al.getCurrentViewWidth() < al.getCanvasLeftBorder()
                && al.getViewRight() < al.getCanvasRightBorder();
    }
}
