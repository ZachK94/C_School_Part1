import java.util.Arrays;

// Six sorting algorithms implementation
// QuickSort,  CountingSort, InsertionSort, HeapSort, MergeSort, BoubleSort implementation based on Ryba class

public class SortingAlgorithms {

    public static void main(String[] args) {

        Ryba ryba1 = new Ryba("Karp", true, 10, 5.0, "szara", new String[]{"Azja, Europa"});
        Ryba ryba2 = new Ryba("Morswin", true, 3, 3.0, "brązowa", new String[]{"Azja, Europa"});
        Ryba ryba3 = new Ryba("Szczupak", true, 1, 3.5, "brązowa", new String[]{"Antarktyda, Europa"});
        Ryba ryba4 = new Ryba("Szprot", false, 2, 3.6, "szara", new String[]{"Azja, Europa"});
        Ryba ryba5 = new Ryba("Tunczyk", false, 6, 2.9, "czarna", new String[]{"Ameryka, Europa"});


        Ryba[] tablicaRyba = {ryba1, ryba2, ryba3, ryba4, ryba5};


        /*
        Quick Sort
         */

        quickSortDown(tablicaRyba, 0, tablicaRyba.length - 1);
        for (int i = tablicaRyba.length - 1; i >= 0; i--) {
            System.out.println(tablicaRyba[i].getNazwa() + " " + tablicaRyba[i].getWaga());
        }

        /*
        Counting Sort
         */

        countingSort(tablicaRyba, tablicaRyba.length - 1);

        /*
        Insertion Sort
         */

        insertionSort(tablicaRyba);

        /*
        Heap Sort
         */

        heapSort(tablicaRyba);
        for (int i = tablicaRyba.length - 1; i >= 0; i--) {
            System.out.println(tablicaRyba[i].getNazwa() + " " + tablicaRyba[i].getWaga());
        }

        /*
        Merge Sort
         */

        mergeSort(tablicaRyba, 0, tablicaRyba.length - 1);
        for (int i = tablicaRyba.length - 1; i >= 0; i--) {
            System.out.println(tablicaRyba[i].getNazwa() + " " + tablicaRyba[i].getWaga());
        }

         /*
        Bouble Sort
         */

        boolean czyBylaZamiana = true;
        while (czyBylaZamiana) {
            czyBylaZamiana = false;
            for (int i = 0; i < tablicaRyba.length - 1; i++) {
                if (tablicaRyba[i].getWaga() < tablicaRyba[i + 1].getWaga()) {
                    Ryba r = tablicaRyba[i];
                    tablicaRyba[i] = tablicaRyba[i + 1];
                    tablicaRyba[i + 1] = r;
                    czyBylaZamiana = true;
                }
            }
        }

        while (!czyPusta(tablicaRyba)) {
            Ryba max = ryba1;
            int poz = 0;
            for (int i = 0; i < tablicaRyba.length && max != null; i++) {
                if (tablicaRyba[i] != null) {
                    max = tablicaRyba[i];
                    poz = i;
                }
            }
            for (int i = 0; i < tablicaRyba.length; i++) {
                if (tablicaRyba[i] != null && tablicaRyba[i].getWaga() > max.getWaga()) {
                    poz = i;
                    max = tablicaRyba[i];
                }
            }
            System.out.println(max.getNazwa() + " " + max.getWaga());
            tablicaRyba[poz] = null;
        }
    }

    private static boolean czyPusta(Ryba[] tablicaRyba) {
        for (Ryba r : tablicaRyba)
            if (r != null)
                return false;
        return true;
    }

    /*
        Quick Sort
    */

    private static void quickSortDown(Ryba[] tablica, int low, int high) {

        int i = low;
        int j = high;
        Ryba temp;
        double middle = tablica[(low + high) / 2].getWaga();

        do {
            while (tablica[i].getWaga() < middle)
                i++;
            while (tablica[j].getWaga() > middle)
                j--;
            if (i <= j) {
                temp = tablica[i];
                tablica[i] = tablica[j];
                tablica[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (low < j) quickSortDown(tablica, low, j);
        if (i < high) quickSortDown(tablica, i, high);

    }


    /*
        Counting Sort
    */

    private static void countingSort(Ryba[] tablica, int lenght) {

        Ryba[] output = new Ryba[lenght];
    //Sortowanie działa tylko dla liczb całkowitych, więc: (int)(tablica[i].getWaga()*10)
    //Znalezienie największego elementu tablicy
        int max = (int) (tablica[0].getWaga() * 10);
        for (int i = 0; i < lenght; i++) {
            if ((int) (tablica[i].getWaga() * 10) > max)
                max = (int) (tablica[i].getWaga() * 10);
        }

    //Inicjacja tablicy z samymi zerami

        int[] zliczanie = new int[max + 1];
        for (int i = 0; i < max; ++i) {
            zliczanie[i] = 0;
        }
    //Przechowywanie każdego elementu
        for (int i = 0; i < lenght; i++) {
            zliczanie[(int) (tablica[i].getWaga() * 10)]++;
        }

        for (int i = 1; i <= max; i++) {
            zliczanie[i] += zliczanie[i - 1];
        }
    //Znalezienie indeksu każdego elementu oryginalnej tablicy w tablicy "zliczanie" i umieszczenie w tablicy wyjsciowej
        for (int i = lenght - 1; i >= 0; i--) {
            output[zliczanie[(int) (tablica[i].getWaga() * 10)] - 1] = tablica[i];
            zliczanie[(int) (tablica[i].getWaga() * 10)]--;
        }

    //Kopiowanie elementu do oryginalnej tablicy
        for (int i = 0; i < lenght; i++) {
            tablica[i] = output[i];

        }
    //Od najcięższej do najlzejszej
        for (int i = tablica.length - 1; i >= 0; i--)
            System.out.println(tablica[i].getNazwa() + " " + tablica[i].getWaga());

    }

    /*
        Insertion Sort
    */

    public static void insertionSort(Ryba[] tablica) {

        for (int i = 1; i < tablica.length; i++) {
            Ryba zmienna = tablica[i];
            double k = tablica[i].getWaga();
            int j = i - 1;
            while ((j >= 0) && (tablica[j].getWaga() > k)) {
                tablica[j + 1] = tablica[j];
                j--;
            }
            tablica[j + 1] = zmienna;
        }

        //od najcięższej do najlzejszej
        for (int i = tablica.length - 1; i >= 0; i--)
            System.out.println(tablica[i].getNazwa() + " " + tablica[i].getWaga());
    }

    /*
        Heap Sort
    */

    public static void heapSort(Ryba[] tablica) {
        Ryba tem;
        int n = tablica.length;
        for (int i = (n / 2) - 1; i >= 0; i--)
            heap(tablica, n, i);
        for (int i = n - 1; i > 0; i--) {
            tem = tablica[0];
            tablica[0] = tablica[i];
            tablica[i] = tem;

            heap(tablica, i, 0);
        }
    }

    public static void heap(Ryba[] tab, int n, int i) {
        //i - index
        //n - rozmiar kopca

        int largest = i; //najwiekszy
        int l = 2 * i + 1;  //lewy
        int r = 2 * i + 2;  //prawy
        Ryba temp;

        if (l < n && tab[l].getWaga() > tab[largest].getWaga())
            largest = l;
        if (r < n && tab[r].getWaga() > tab[largest].getWaga())
            largest = r;
        if (largest != i) {
            temp = tab[i];
            tab[i] = tab[largest];
            tab[largest] = temp;

            heap(tab, n, largest);
        }
    }

    /*
        Merge Sort
    */

    public static void mergeFinal(Ryba[] tablica, int begin, int middle, int end) {

        int n1 = middle - begin + 1;
        int n2 = end - middle;

        Ryba[] left = new Ryba[n1];
        Ryba[] right = new Ryba[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = tablica[begin + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = tablica[middle + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = begin;
        while (i < n1 && j < n2) {
            if (left[i].getWaga() <= right[j].getWaga()) {
                tablica[k] = left[i];
                i++;
            } else {
                tablica[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            tablica[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            tablica[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(Ryba[] tablica, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) / 2;

            mergeSort(tablica, begin, middle);
            mergeSort(tablica, middle + 1, end);

            mergeFinal(tablica, begin, middle, end);
        }
    }
}

class Ryba {

    private boolean czySlodka;
    private int dlugoscZycia;
    private double waga;
    private String kolor;
    private String nazwa;
    private String[] miejsceWystepowania;

    public Ryba(String nazwa, boolean czySlodka, int dlugoscZycia, double waga, String kolor, String[] miejsceWystepowania) {
        this.czySlodka = czySlodka;
        this.dlugoscZycia = dlugoscZycia;
        this.waga = waga;
        this.kolor = kolor;
        this.miejsceWystepowania = miejsceWystepowania;
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public boolean isCzySlodka() {
        return czySlodka;
    }

    public void setCzySlodka(boolean czySlodka) {
        this.czySlodka = czySlodka;
    }

    public int getDlugoscZycia() {
        return dlugoscZycia;
    }

    public void setDlugoscZycia(int dlugoscZycia) {
        this.dlugoscZycia = dlugoscZycia;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String[] getMiejsceWystepowania() {
        return miejsceWystepowania;
    }

    public void setMiejsceWystepowania(String[] miejsceWystepowania) {
        this.miejsceWystepowania = miejsceWystepowania;
    }

}



