package library.chips.layouter.breaker;

import library.chips.layouter.AbstractLayouter;

class ForwardBreakerContract extends RowBreakerDecorator {

    private IRowBreaker breaker;

    ForwardBreakerContract(IRowBreaker breaker, ILayoutRowBreaker decorate) {
        super(decorate);
        this.breaker = breaker;
    }

    @Override
    public boolean isRowBroke(AbstractLayouter al) {
        return super.isRowBroke(al) ||
                (al.getCurrentViewPosition() != 0 && breaker.isItemBreakRow(al.getCurrentViewPosition() - 1));
    }
}
