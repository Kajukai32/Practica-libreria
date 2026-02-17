package customexceptions;

public class InvalidFieldContentException extends Exception {

	private String msg;

	public InvalidFieldContentException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidFieldContentException [msg=" + msg + "]";
	}
	
}
