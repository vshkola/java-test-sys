package Unit2.utilites;

import java.util.Random;


/**
 * Shuffling any array and returning an array of Object[]
 *
 * @version 1.0.1 17/10/13
 */
public final class Shuffler {
    private final Object[] shuffled;

    public Shuffler(Object[] array) {
        this.shuffled = shuffle(array);
    }

    private Object[] shuffle(Object[] array) {
        Random rnd = new Random();
        for (int elementIndex = array.length; elementIndex > 1; elementIndex--)
            swap(array, elementIndex - 1, rnd.nextInt(elementIndex));
        return array;
    }

    private void swap(Object[] array, int firstIndex, int randomIndex) {
        Object tmp = array[firstIndex];
        array[firstIndex] = array[randomIndex];
        array[randomIndex] = tmp;
    }

    public Object[] getShuffled() {
        return shuffled;
    }
}