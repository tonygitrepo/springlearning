package com.socialmedia.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(serviceName="TimelineWebService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class TimelineWebService {

	
	//DI via Spring
		TimelineWebserviceBO timelineWebserviceBo;

		@WebMethod(exclude=true)
		public void setTimelineWebserviceBo(TimelineWebserviceBO timelineWsBo) {
			this.timelineWebserviceBo = timelineWsBo;
		}

		@WebMethod(operationName="getTimeline")
		public String getTimelineOne() {
			
			return timelineWebserviceBo.getTimeline();
			
		}
	
}
