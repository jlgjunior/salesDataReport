package salesDataReport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.SalespersonBuilder;

public class SalespersonBuilderTest {

	@Test
	public void getNameTest() {
		final String NAME = "Bob";
		SalespersonBuilder salespersonBuilder = new SalespersonBuilder();
		ReflectionTestUtils.setField(salespersonBuilder, "name", NAME);
		assertEquals(NAME, salespersonBuilder.getName());
	}
	
	@Test
	public void setNameTest() {
		final String NAME = "Bob";
		SalespersonBuilder salespersonBuilder = new SalespersonBuilder();
		salespersonBuilder.setName(NAME);
		assertEquals(NAME, salespersonBuilder.getName());
	}
	
	@Test
	public void getCpfTest() {
		final String CPF = "01283219038";
		SalespersonBuilder salespersonBuilder = new SalespersonBuilder();
		ReflectionTestUtils.setField(salespersonBuilder, "cpf", CPF);
		assertEquals(CPF, salespersonBuilder.getCpf());
	}
	
	@Test
	public void setCpfTest() {
		final String CPF = "01283219038";
		SalespersonBuilder salespersonBuilder = new SalespersonBuilder();
		salespersonBuilder.setCpf(CPF);
		assertEquals(CPF, salespersonBuilder.getCpf());
	}

	@Test
	public void getSalaryTest() {
		final Float SALARY = 9038f;
		SalespersonBuilder salespersonBuilder = new SalespersonBuilder();
		ReflectionTestUtils.setField(salespersonBuilder, "salary", SALARY);
		assertEquals(SALARY, salespersonBuilder.getSalary());
	}
	
	@Test
	public void setSalaryTest() {
		final Float SALARY = 9038f;
		SalespersonBuilder salespersonBuilder = new SalespersonBuilder();
		salespersonBuilder.setSalary(SALARY);
		assertEquals(SALARY, salespersonBuilder.getSalary());
	}
}
