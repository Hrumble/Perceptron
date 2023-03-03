public class Main {
    public static void main(String[] args) {
        // Example usage
        double[][] inputs = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int[] targets = {-1, -1, -1, 1};



        Perceptron perceptron = new Perceptron(2, 0.1);
        System.out.println("Before training: ");

        System.out.println(perceptron.predict(new double[]{0, 0}, true)); // -1
        System.out.println(perceptron.predict(new double[]{0, 1}, true)); // -1
        System.out.println(perceptron.predict(new double[]{1, 0},true)); // -1
        System.out.println(perceptron.predict(new double[]{1, 1}, true)); // 1

        perceptron.train(inputs, targets, 1000);

        System.out.println("After training: ");

        // Test predictions
        System.out.println(perceptron.predict(new double[]{0, 0}, true)); // -1
        System.out.println(perceptron.predict(new double[]{0, 1}, true)); // -1
        System.out.println(perceptron.predict(new double[]{1, 0}, true)); // -1
        System.out.println(perceptron.predict(new double[]{1, 1},true)); // 1
    }
}
