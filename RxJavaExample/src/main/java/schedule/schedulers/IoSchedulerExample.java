package schedule.schedulers;

import java.io.File;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class IoSchedulerExample {

	public void emit()
	{
		String root = "c:\\";
		File  files[] = new File(root).listFiles();
		Observable.fromArray(files)
		.filter(file-> file.isDirectory())
		.map(file -> file.getAbsolutePath())
		.subscribeOn(Schedulers.io())
		.subscribe(Log::i);
		CommUtil.sleep(500);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IoSchedulerExample example = new IoSchedulerExample();
		example.emit();
	}

}
