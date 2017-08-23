import java.util.List;

public class Project {
	private List<TestCase> listTestCase;
	private String projectId;
	private int countDesign, countReady, countAuto, countManual;

	public List<TestCase> getListTestCase() {
		return listTestCase;
	}

	public void setListTestCase(List<TestCase> listTestCase) {
		this.listTestCase = listTestCase;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void AddTestCase(TestCase tc) {
		this.listTestCase.add(tc);
	}

	public int countTestCase() {
		return listTestCase.size();
	}

	public void count(){
		
		for(int i = 0; i < listTestCase.size(); i++){
			if ("auto".equals(listTestCase.get(i).getAuto())) {
				countAuto++;
			} else {
				countManual++;
			}
			
			if ("ready".equals(listTestCase.get(i).getAuto())) {
				countReady++;
			} else {
				countDesign++;
			}
		}
		
	}
}
