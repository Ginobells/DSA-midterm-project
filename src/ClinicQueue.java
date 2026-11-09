public class ClinicQueue {

    private static final int MAX_SIZE = 500;

    // Stores all registered patients
    private static Patient[] allPatients =
            new Patient[MAX_SIZE];

    private static int registeredCount = 0;

    // Manually implemented circular queue
    private static Patient[] waitingQueue =
            new Patient[MAX_SIZE];

    private static int front = 0;
    private static int rear = -1;
    private static int waitingCount = 0;


    // Register Patient
    public static boolean registerPatient(Patient patient) { 

        if (patient == null) {
            return false;
        }

        if (registeredCount >= MAX_SIZE) {
            return false;
        }

        // Check duplicate ID using manual linear search
        if (searchPatient(patient.getId()) != null) {
            return false;
        }

        // Store in registered patients array
        allPatients[registeredCount] = patient;
        registeredCount++;

        // Add patient to waiting queue
        rear = (rear + 1) % MAX_SIZE;
        waitingQueue[rear] = patient;
        waitingCount++;

        return true;
    }


    // Call Next Patient (Dequeue)
    public static Patient callNextPatient() {

        if (waitingCount == 0) {
            return null;
        }

        Patient patient = waitingQueue[front];

        waitingQueue[front] = null;

        front = (front + 1) % MAX_SIZE;
        waitingCount--;

        if (waitingCount == 0) {
            front = 0;
            rear = -1;
        }

        return patient;
    }


    // Manual Linear Search by Patient ID
    public static Patient searchPatient(String id) {

        if (id == null) {
            return null;
        }

        for (int i = 0; i < registeredCount; i++) {

            if (allPatients[i].getId().equalsIgnoreCase(id)) {
                return allPatients[i];
            }
        }

        return null;
    }


    // Get total registered patients
    public static int getRegisteredCount() {
        return registeredCount;
    }


    // Get total waiting patients
    public static int getWaitingCount() {
        return waitingCount;
    }


    // Get a waiting patient using its position
    public static Patient getWaitingPatientAt(int index) {

        if (index < 0 || index >= waitingCount) {
            return null;
        }

        int position = (front + index) % MAX_SIZE;

        return waitingQueue[position];
    }

}

