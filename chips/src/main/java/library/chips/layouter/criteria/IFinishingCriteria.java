package library.chips.layouter.criteria;

import library.chips.layouter.AbstractLayouter;

public interface IFinishingCriteria {
    /** check if layouting finished by criteria */
    boolean isFinishedLayouting(AbstractLayouter abstractLayouter);
}
