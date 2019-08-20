package co.jp.aoyama.test;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobLauncher_JobShukka {
	private static ApplicationContext context;

	public static void main(String[] args1) {
		context = new ClassPathXmlApplicationContext(
				"file:D:\\aoyama\\workspace\\aoyama-macchinetta-batch\\src\\main\\resources\\META-INF\\jobs\\JobShukka.xml");
		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("JobShukka");

		try {

			Map<String, JobParameter> map = new LinkedHashMap<String, JobParameter>();
			JobParameter jb = new JobParameter(new Date(), true);
			map.put("id", jb);
			JobParameters jobParameters = new JobParameters(map);

			// JOB实行
			JobExecution result = launcher.run(job, jobParameters);
			// 运行结果输出
			System.out.println(result.toString());
			System.out.println("テスト完了");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
