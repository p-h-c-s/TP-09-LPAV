package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadMainTest {

    @Test
    void main() {

        int tamVetor = 8;
        int numThreads = 2;
        int tamIntervalo = tamVetor/numThreads;
        int vet[] = new int[tamVetor];
        //int vetExpected[] =  {0,1}
        icomp.ThreadMain.generateIntervals(vet,tamIntervalo);
        for (int i :vet) System.out.println(i);
        //assertArrayEquals(vet,vetExpected);


        int vet2[] = icomp.ThreadMain.generateRandomArray(10);
        System.out.println("-----");
        for (int i :vet2) System.out.println(i);

    }
}