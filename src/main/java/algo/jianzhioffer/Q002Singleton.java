package algo.jianzhioffer;

public class Q002Singleton {

	private static Q002Singleton ins;

	public Q002Singleton getInstance() {
		if (ins == null) {
			synchronized (this) {
				ins = new Q002Singleton();
			}
		}
		return ins;
	}
}
