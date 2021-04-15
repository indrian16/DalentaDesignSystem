package tech.dalenta.component.utils


object ViewUtils {

    fun getOverflowDimension(dimension: Int): Int {
        return if (dimension == -1 || dimension == 0) {
            -1
        } else {
            dimension
        }
    }

}