package library.chips;

interface IStateHolder {
    boolean isLayoutRTL();

    @Orientation
    int layoutOrientation();

}
