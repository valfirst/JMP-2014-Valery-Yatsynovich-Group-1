import java.util.ArrayList;
import java.util.List;

public class HeapException {

	public static void main(String[] args)
	{
		List<byte[]> list = new ArrayList<byte[]>();

		while (true)
		{
			byte[] load = new byte[1 * 1024];
			list.add(load);
		}
	}

}