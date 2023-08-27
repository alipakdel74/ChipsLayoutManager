package library.chips.gravity;

import library.chips.layouter.AbstractLayouter;
import library.chips.layouter.Item;

import java.util.List;

public interface IRowStrategy {
    void applyStrategy(AbstractLayouter abstractLayouter, List<Item> row);
}
