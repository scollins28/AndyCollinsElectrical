package fdm.com.java.AndyCollinsElectrical;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "jobsList")
public class Job {
	@Id
	@Column(name = "job_id", length = 8)
	private int jobId;
	@ManyToMany
	@JoinTable(name = "customers_jobs", // name of joining table
	joinColumns = @JoinColumn(name = "job_id") , // pk of this table
	inverseJoinColumns = @JoinColumn(name = "customer_id") ) // pk of other
																// table
	private List<Customer> customers;
	@ManyToMany
	@JoinTable(name = "jobs_stock", // name of joining table
	joinColumns = @JoinColumn(name = "job_id") , // pk of this table
	inverseJoinColumns = @JoinColumn(name = "stock_id") ) // pk of other table
	private List<StockItem> stockAssigned;
	@Column(name = "labour_hours_assigned", length = 8)
	private double labourHoursAssigned;
	@Column(name = "labour_hours_actual", length = 8)
	private double labourHoursActual;
	@Column(name = "labour_hours_charged", length = 8)
	private double labourHoursCharged;
	@Column(name = "labour_cost_assigned", length = 9)
	private double labourCostAssigned;
	@Column(name = "labour_cost_actual", length = 9)
	private double laboutCostActual;
	@Column(name = "labour_cost_charged", length = 9)
	private double labourCostCharged;
	@Column(name = "customer_invoice_value", length = 9)
	private double customerInvoiceValue;
	@Column(name = "customer_quoted_value", length = 9)
	private double customerQuotedValue;
	@Column(name = "profitability", length = 9)
	private double profitability;
	@Column(name = "quoted", length = 4)
	private boolean quoted;
	@Column(name = "invoiced", length = 4)
	private boolean invoiced;
	@Column(name = "date_started", length = 50)
	@Temporal(TemporalType.DATE)
	private Date dateStarted;
	@Temporal(TemporalType.DATE)
	@Column(name = "est_completion_date", length = 50)
	private Date estCompletionDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "act_completion_date", length = 50)
	private Date actCompletionDate;
	@Column(name = "job_completed", length = 4)
	private boolean jobCompleted;

	public Job() {
		super();
	}

	public Job(int jobId, List<Customer> customers, List<StockItem> stockAssigned, double labourHoursAssigned,
			double labourHoursActual, double labourHoursCharged, double labourCostAssigned, double laboutCostActual,
			double labourCostCharged, double customerInvoiceValue, double customerQuotedValue, double profitability,
			boolean quoted, boolean invoiced, Date dateStarted, Date estCompletionDate, Date actCompletionDate,
			boolean jobCompleted) {
		super();
		this.jobId = jobId;
		this.customers = customers;
		this.stockAssigned = stockAssigned;
		this.labourHoursAssigned = labourHoursAssigned;
		this.labourHoursActual = labourHoursActual;
		this.labourHoursCharged = labourHoursCharged;
		this.labourCostAssigned = labourCostAssigned;
		this.laboutCostActual = laboutCostActual;
		this.labourCostCharged = labourCostCharged;
		this.customerInvoiceValue = customerInvoiceValue;
		this.customerQuotedValue = customerQuotedValue;
		this.profitability = profitability;
		this.quoted = quoted;
		this.invoiced = invoiced;
		this.dateStarted = dateStarted;
		this.estCompletionDate = estCompletionDate;
		this.actCompletionDate = actCompletionDate;
		this.jobCompleted = jobCompleted;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setStockAssigned(List<StockItem> stockAssigned) {
		this.stockAssigned = stockAssigned;
	}

	public double getLabourHoursAssigned() {
		return labourHoursAssigned;
	}

	public void setLabourHoursAssigned(double labourHoursAssigned) {
		this.labourHoursAssigned = labourHoursAssigned;
	}

	public double getLabourHoursActual() {
		return labourHoursActual;
	}

	public void setLabourHoursActual(double labourHoursActual) {
		this.labourHoursActual = labourHoursActual;
	}

	public double getLabourHoursCharged() {
		return labourHoursCharged;
	}

	public void setLabourHoursCharged(double labourHoursCharged) {
		this.labourHoursCharged = labourHoursCharged;
	}

	public double getLabourCostAssigned() {
		return labourCostAssigned;
	}

	public void setLabourCostAssigned(double labourCostAssigned) {
		this.labourCostAssigned = labourCostAssigned;
	}

	public double getLaboutCostActual() {
		return laboutCostActual;
	}

	public void setLaboutCostActual(double laboutCostActual) {
		this.laboutCostActual = laboutCostActual;
	}

	public double getLabourCostCharged() {
		return labourCostCharged;
	}

	public void setLabourCostCharged(double labourCostCharged) {
		this.labourCostCharged = labourCostCharged;
	}

	public double getCustomerInvoiceValue() {
		return customerInvoiceValue;
	}

	public void setCustomerInvoiceValue(double customerInvoiceValue) {
		this.customerInvoiceValue = customerInvoiceValue;
	}

	public double getCustomerQuotedValue() {
		return customerQuotedValue;
	}

	public void setCustomerQuotedValue(double customerQuotedValue) {
		this.customerQuotedValue = customerQuotedValue;
	}

	public double getProfitability() {
		return profitability;
	}

	public void setProfitability(double profitability) {
		this.profitability = profitability;
	}

	public boolean isQuoted() {
		return quoted;
	}

	public void setQuoted(boolean quoted) {
		this.quoted = quoted;
	}

	public boolean isInvoiced() {
		return invoiced;
	}

	public void setInvoiced(boolean invoiced) {
		this.invoiced = invoiced;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Date getEstCompletionDate() {
		return estCompletionDate;
	}

	public void setEstCompletionDate(Date estCompletionDate) {
		this.estCompletionDate = estCompletionDate;
	}

	public Date getActCompletionDate() {
		return actCompletionDate;
	}

	public void setActCompletionDate(Date actCompletionDate) {
		this.actCompletionDate = actCompletionDate;
	}

	public boolean isJobCompleted() {
		return jobCompleted;
	}

	public void setJobCompleted(boolean jobCompleted) {
		this.jobCompleted = jobCompleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actCompletionDate == null) ? 0 : actCompletionDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(customerInvoiceValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(customerQuotedValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((dateStarted == null) ? 0 : dateStarted.hashCode());
		result = prime * result + ((estCompletionDate == null) ? 0 : estCompletionDate.hashCode());
		result = prime * result + (invoiced ? 1231 : 1237);
		result = prime * result + (jobCompleted ? 1231 : 1237);
		result = prime * result + jobId;
		temp = Double.doubleToLongBits(labourCostAssigned);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(labourCostCharged);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(labourHoursActual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(labourHoursAssigned);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(labourHoursCharged);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(laboutCostActual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(profitability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (quoted ? 1231 : 1237);
		result = prime * result + ((stockAssigned == null) ? 0 : stockAssigned.hashCode());
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
		Job other = (Job) obj;
		if (actCompletionDate == null) {
			if (other.actCompletionDate != null)
				return false;
		} else if (!actCompletionDate.equals(other.actCompletionDate))
			return false;
		if (Double.doubleToLongBits(customerInvoiceValue) != Double.doubleToLongBits(other.customerInvoiceValue))
			return false;
		if (Double.doubleToLongBits(customerQuotedValue) != Double.doubleToLongBits(other.customerQuotedValue))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (dateStarted == null) {
			if (other.dateStarted != null)
				return false;
		} else if (!dateStarted.equals(other.dateStarted))
			return false;
		if (estCompletionDate == null) {
			if (other.estCompletionDate != null)
				return false;
		} else if (!estCompletionDate.equals(other.estCompletionDate))
			return false;
		if (invoiced != other.invoiced)
			return false;
		if (jobCompleted != other.jobCompleted)
			return false;
		if (jobId != other.jobId)
			return false;
		if (Double.doubleToLongBits(labourCostAssigned) != Double.doubleToLongBits(other.labourCostAssigned))
			return false;
		if (Double.doubleToLongBits(labourCostCharged) != Double.doubleToLongBits(other.labourCostCharged))
			return false;
		if (Double.doubleToLongBits(labourHoursActual) != Double.doubleToLongBits(other.labourHoursActual))
			return false;
		if (Double.doubleToLongBits(labourHoursAssigned) != Double.doubleToLongBits(other.labourHoursAssigned))
			return false;
		if (Double.doubleToLongBits(labourHoursCharged) != Double.doubleToLongBits(other.labourHoursCharged))
			return false;
		if (Double.doubleToLongBits(laboutCostActual) != Double.doubleToLongBits(other.laboutCostActual))
			return false;
		if (Double.doubleToLongBits(profitability) != Double.doubleToLongBits(other.profitability))
			return false;
		if (quoted != other.quoted)
			return false;
		if (stockAssigned == null) {
			if (other.stockAssigned != null)
				return false;
		} else if (!stockAssigned.equals(other.stockAssigned))
			return false;
		return true;
	}

}
