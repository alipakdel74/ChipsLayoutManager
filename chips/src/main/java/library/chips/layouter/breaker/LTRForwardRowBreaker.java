package library.chips.layouter.breaker;

import library.chips.layouter.AbstractLayouter;

/** this is basis row breaker for {@link library.chips.layouter.LTRDownLayouter} */
class LTRForwardRowBreaker implements ILayoutRowBreaker {

    @Override
    public boolean isRowBroke(AbstractLayouter al) {
        return al.getViewLeft() > al.getCanvasLeftBorder()
                && al.getViewLeft() + al.getCurrentViewWidth() > al.getCanvasRightBorder();
    }
}
