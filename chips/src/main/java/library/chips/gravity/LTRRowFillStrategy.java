package library.chips.gravity;

import android.graphics.Rect;

import library.chips.layouter.AbstractLayouter;
import library.chips.layouter.Item;

import java.util.List;

class LTRRowFillStrategy implements IRowStrategy {

    @Override
    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> row) {
        int difference = GravityUtil.getHorizontalDifference(abstractLayouter) / abstractLayouter.getRowSize();
        int offsetDifference = difference;

        for (Item item : row) {

            Rect childRect = item.getViewRect();

            if (childRect.left == abstractLayouter.getCanvasLeftBorder()) {
                //left view of row

                int leftDif = childRect.left - abstractLayouter.getCanvasLeftBorder();
                //press view to left border
                childRect.left = abstractLayouter.getCanvasLeftBorder();
                childRect.right -= leftDif;

                //increase view width from right
                childRect.right += offsetDifference;
                continue;
            }

            childRect.left += offsetDifference;
            offsetDifference += difference;
            childRect.right += offsetDifference;
        }

    }
}
