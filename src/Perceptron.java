public class Perceptron {
    private double[] weights;
    private double bias;
    private double learningRate;

    public Perceptron(int numInputs, double learningRate) {
        this.weights = new double[numInputs];
        this.bias = 0;
        this.learningRate = learningRate;
        for (int i = 0; i < numInputs; i++) {
            this.weights[i] = Math.random(); // initialize weights randomly
        }
    }

    public int predict(double[] inputs, boolean show) {
        double activation = 0;
        for (int i = 0; i < inputs.length; i++) {
            activation += inputs[i] * weights[i];
        }
        activation += bias;
        int result = activation >= 0 ? 1 : -1;
        if(show){
            System.out.println("Inputs: [" + inputs[0] + ", "+ inputs[1] + "]");
            System.out.println("Result: " + result);
        }
        return result;
    }

    public void train(double[][] inputs, int[] targets, int numEpochs) {
        for (int epoch = 0; epoch < numEpochs; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                int output = predict(inputs[i], false);
                int error = targets[i] - output;
                bias += learningRate * error;
                for (int j = 0; j < weights.length; j++) {
                    weights[j] += learningRate * error * inputs[i][j];
                }
            }
        }
    }
}
