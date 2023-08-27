package library.chips.layouter.criteria;

import library.chips.layouter.AbstractLayouter;

public class EmtpyCriteria implements IFinishingCriteria {
    @Override
    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return true;
    }

}
