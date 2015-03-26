/* This class lists all the attributes found for the switch */

package json.switches;

public class Attributes {

	private Long FastWildcards;
	private Boolean supportsNxRole;
	private Boolean supportsOfppFlood;
	private Boolean supportsOfppTable;

	public Long getFastWildcards() {
		return FastWildcards;
	}

	public void setFastWildcards(Long FastWildcards) {
		this.FastWildcards = FastWildcards;
	}

	public Attributes withFastWildcards(Long FastWildcards) {
		this.FastWildcards = FastWildcards;
		return this;
	}

	public Boolean getSupportsNxRole() {
		return supportsNxRole;
	}

	public void setSupportsNxRole(Boolean supportsNxRole) {
		this.supportsNxRole = supportsNxRole;
	}

	public Attributes withSupportsNxRole(Boolean supportsNxRole) {
		this.supportsNxRole = supportsNxRole;
		return this;
	}

	public Boolean getSupportsOfppFlood() {
		return supportsOfppFlood;
	}

	public void setSupportsOfppFlood(Boolean supportsOfppFlood) {
		this.supportsOfppFlood = supportsOfppFlood;
	}

	public Attributes withSupportsOfppFlood(Boolean supportsOfppFlood) {
		this.supportsOfppFlood = supportsOfppFlood;
		return this;
	}

	public Boolean getSupportsOfppTable() {
		return supportsOfppTable;
	}

	public void setSupportsOfppTable(Boolean supportsOfppTable) {
		this.supportsOfppTable = supportsOfppTable;
	}

	public Attributes withSupportsOfppTable(Boolean supportsOfppTable) {
		this.supportsOfppTable = supportsOfppTable;
		return this;
	}

}