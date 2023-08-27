package library.chips.layouter.criteria;

import library.chips.layouter.AbstractLayouter;

abstract class FinishingCriteriaDecorator implements IFinishingCriteria {

    private IFinishingCriteria finishingCriteria;

    FinishingCriteriaDecorator(IFinishingCriteria finishingCriteria) {
        this.finishingCriteria = finishingCriteria;
    }

    @Override
    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return finishingCriteria.isFinishedLayouting(abstractLayouter);
    }
}
