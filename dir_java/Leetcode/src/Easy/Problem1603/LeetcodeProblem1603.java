package src.Easy.Problem1603;

import java.util.*;

class ParkingSystem {
    private int availableBigSpots = 0;
    private int availableMedSpots = 0;
    private int availableSmallSpots = 0;

    public ParkingSystem(int big, int medium, int small) {
        availableBigSpots = big;
        availableMedSpots = medium;
        availableSmallSpots = small;
    }
    
    public boolean addCar(int carType) {
        boolean parkingSuccess = false;

        switch (carType){
            case 1: 
                parkingSuccess = availableBigSpots > 0 ? true : false;
                if ( parkingSuccess ) { availableBigSpots = availableBigSpots - 1; }
                break;
            case 2:
                parkingSuccess = availableMedSpots > 0 ? true : false;
                if ( parkingSuccess ) { availableMedSpots = availableMedSpots - 1; }
                break;
            case 3:
                parkingSuccess = availableSmallSpots > 0 ? true : false;
                if ( parkingSuccess ) { availableSmallSpots = availableSmallSpots - 1; }
                break;
            default: return parkingSuccess;
        }

        return parkingSuccess;
        
    }

}

class Solution {
    
    public static void main(String[] args){ 
        String [] cmds = new String[]{"ParkingSystem", "addCar", "addCar", "addCar", "addCar"};
        int [][] inputs = new int[][]{
            {1, 1, 0}, {1}, {2}, {3}, {1}
        };

        String [] outputs = new String[inputs.length];

        ParkingSystem parkingSystem = null;

        for (int inputIdx = 0; inputIdx < inputs.length; inputIdx++ ){
            if ( cmds[inputIdx] == "ParkingSystem" ){
                parkingSystem = new ParkingSystem(
                    inputs[inputIdx][0],
                    inputs[inputIdx][1],
                    inputs[inputIdx][2]
                );

                outputs[inputIdx] = "null";
            }

            else if ( cmds[inputIdx] == "addCar" ){
                if ( parkingSystem != null ){
                    boolean res = parkingSystem.addCar(inputs[inputIdx][0]);
                    outputs[inputIdx] = String.valueOf(res);
                }
            }
        }

        for (int inputIdx = 0; inputIdx < inputs.length; inputIdx++ ){
            System.out.println(cmds[inputIdx]);
            System.out.println(inputs[inputIdx][0]);
            System.out.println(outputs[inputIdx]);
        }
    }
}