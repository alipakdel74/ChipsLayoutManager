package library.chips;


import androidx.recyclerview.widget.RecyclerView;

interface IDisappearingViewsManager {
    DisappearingViewsManager.DisappearingViewsContainer getDisappearingViews(RecyclerView.Recycler recycler);

    int calcDisappearingViewsLength(RecyclerView.Recycler recycler);

    int getDeletingItemsOnScreenCount();

    void reset();
}
