package com.example.webservice.service.employee.impl;


import com.example.webservice.mapper.employee.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplementsTests {
    // mockito Mock 을 사용하여 Mock을 작성 합니다.
    // 작성하지 않을시 빈 객체가 주입되어 null pointere등의 에러가 날 수 있습니다.
    // Mapper를 Mockup하여 db에 연결하여 데이터를 가져오는 것 자체가 Mockup 됩니다.
    @Mock
    private EmployeeMapper employeeMapper;

    // 위 Mock객체를 주입합니다. **
    @InjectMocks
    private EmployeeServiceImplement employeeServiceImplement;

//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testGetEmployee() throws Exception {
        // TestCase 01 - Success
        // method 하나를 testcase 하나로 사용해도 되고, method 하나에 여러개의 case를 나열식으 구성해도 되고,
        // for의 switch들을 이용해 한 번에 구현할 수도 있습니다. 편한 방법으로 구성 하시면 됩니다.

        // given
        // 테스트에 사용할 객체들을 선언
        List<Map<String, Object>> employees = new ArrayList<Map<String, Object>>();
        Map<String, Object> employee = new HashMap<String, Object>();
        employee.put("name", "Seongsu");
        employee.put("age", "23");
        employees.add(employee);

        // when
        // dao에서 사용하는 외부 메서드들을 구체적으로 mockup해줍니다.
        // ~가 들어오면 ~가 return 된다.
        when(employeeMapper.getEmployee()).thenReturn(employees);

        // then
        assertThat(employeeServiceImplement.getEmployee()).isEqualTo(employees);
    }
}
