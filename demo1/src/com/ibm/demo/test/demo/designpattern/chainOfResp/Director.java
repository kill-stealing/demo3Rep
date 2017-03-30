package com.ibm.demo.test.demo.designpattern.chainOfResp;

/**
 * 主任
 * 
 * @author liumy
 *
 */
public class Director extends Leader {

	public Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getLeaveDays() < 3) {
			System.out.println("员工：" + request.getEmpName() + "请假，天数："
					+ request.getLeaveDays() + ",理由：" + request.getReason());
			System.out.println("主任:"+this.name+"，审批通过！");
		} else {
			if (this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}

}
