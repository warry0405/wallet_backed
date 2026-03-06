package exception;

public class WalletNotFound extends Exception {
    public WalletNotFound() {
    }

    public WalletNotFound(String message) {
        super(message);
    }
}
