class ParkingSystem {
    int bigs,mediums,smalls;
    public ParkingSystem(int big, int medium, int small) {
        this.bigs=big;
        this.mediums=medium;
        this.smalls=small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            bigs--;
            return bigs>=0;
        }
        else if(carType==2){
            mediums--;
            return mediums>=0;
        }
        else {
            smalls--;
            return smalls>=0;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */