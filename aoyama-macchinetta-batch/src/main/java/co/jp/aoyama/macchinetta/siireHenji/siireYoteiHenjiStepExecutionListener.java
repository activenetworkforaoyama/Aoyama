package co.jp.aoyama.macchinetta.siireHenji;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("siireYoteiHenjiStepExecutionListener")
@Scope("step")
public class siireYoteiHenjiStepExecutionListener implements StepExecutionListener {

	@Value("${prdResData}")
    private File inputFile;
	
	private static final Logger logger = LoggerFactory.getLogger(siireYoteiHenjiStepExecutionListener.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
		if (!inputFile.exists()) {
			logger.error("step finished.The input file is not exist.[JobID:{}][JobName:{}][jobExecutionId:{}][ExitStatus:{}]"
	                ,stepExecution.getJobExecution().getJobId(),stepExecution.getJobExecution().getJobInstance().getJobName()
	                ,stepExecution.getId(), stepExecution.getExitStatus().getExitCode());
        }
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}

}
