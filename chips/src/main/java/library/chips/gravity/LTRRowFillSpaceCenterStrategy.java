package library.chips.gravity;

import android.graphics.Rect;

import library.chips.layouter.AbstractLayouter;
import library.chips.layouter.Item;

import java.util.List;

class LTRRowFillSpaceCenterStrategy implements IRowStrategy {

    @Override
    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> row) {
        int difference = GravityUtil.getHorizontalDifference(abstractLayouter) / (abstractLayouter.getRowSize() + 1);
        int offsetDifference = 0;

        for (Item item : row) {
            Rect childRect = item.getViewRect();

            offsetDifference += difference;

            childRect.left += offsetDifference;
            childRect.right += offsetDifference;
        }
    }
}
