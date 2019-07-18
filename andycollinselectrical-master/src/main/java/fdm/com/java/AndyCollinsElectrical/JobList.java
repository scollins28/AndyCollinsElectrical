package fdm.com.java.AndyCollinsElectrical;

import java.util.ArrayList;

public class JobList {
	
	private ArrayList <Job> jobs;
	
	

	public JobList(ArrayList<Job> jobs) {
		super();
		this.jobs = jobs;
	}

	public ArrayList<Job> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobList other = (JobList) obj;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		return true;
	}
	
	

}
