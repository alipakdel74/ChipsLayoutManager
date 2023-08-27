package library.chips.gravity;

import android.graphics.Rect;

import library.chips.layouter.AbstractLayouter;
import library.chips.layouter.Item;

import java.util.List;

class ColumnFillSpaceCenterDenseStrategy implements IRowStrategy {

    @Override
    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> row) {
        int difference = GravityUtil.getVerticalDifference(abstractLayouter) / 2;

        for (Item item : row) {
            Rect childRect = item.getViewRect();
            childRect.top += difference;
            childRect.bottom += difference;
        }
    }
}
