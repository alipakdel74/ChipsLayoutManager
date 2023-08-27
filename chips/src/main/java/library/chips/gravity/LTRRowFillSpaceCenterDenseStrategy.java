package library.chips.gravity;

import android.graphics.Rect;

import library.chips.layouter.AbstractLayouter;
import library.chips.layouter.Item;

import java.util.List;

class LTRRowFillSpaceCenterDenseStrategy implements IRowStrategy {

    @Override
    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> row) {
        int difference = GravityUtil.getHorizontalDifference(abstractLayouter) / 2;

        for (Item item : row) {
            Rect childRect = item.getViewRect();
            childRect.left += difference;
            childRect.right += difference;
        }
    }
}
