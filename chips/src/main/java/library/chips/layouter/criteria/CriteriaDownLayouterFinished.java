package library.chips.layouter.criteria;

import library.chips.layouter.AbstractLayouter;

class CriteriaDownLayouterFinished implements IFinishingCriteria {

    private boolean isFinished;

    @Override
    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        isFinished = isFinished || abstractLayouter.getViewTop() >= abstractLayouter.getCanvasBottomBorder();
        return isFinished;
    }

}
