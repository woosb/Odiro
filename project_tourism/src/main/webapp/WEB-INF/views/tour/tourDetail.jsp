<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보</title>
</head>
<body>
	<c:import url="../default/header.jsp"/>
		
		<div style="width: 25%; align-content: left;">
			<img style="height: 600px; width: 600px;"onerror="this.src='/resources/images/noimage.png'" src="${map.info.firstimage }">
		</div>
		${map.info.title }<br>
		${map.info.createdtime }<br>
		${map.info.modifiedtime}<br>
		${map.info.mapx}<br>
		${map.info.mapy}<br>
		${map.info.mlevel}<br>
		${map.info.addr1}<br>
		${map.info.tel}<br>
		${map.info.homepage}<br>
		${map.info.overview}<br>
		
		<div id="map" style="width:500px;height:400px;"></div>
		<hr>
		<div id="roadview" style="width:800px;height:400px;"></div>
		
		<input type="button" value="즐겨찾기 추가" onclick="addWishList();">
	<c:import url="../default/footer.jsp"/>
</body>
<script>
	var contentId = "${contentid}";
	var contentTypeId = "${contenttypeid}"
	var list = {contentId : contentId, contentTypeId: contentTypeId}
	function addWishList(){
		console.log(list);
		$.ajax({
			url:"/memberDetail/addWishList",
			type:"POST",
			data: JSON.stringify(list),
	        contentType: "application/json",
			success : function(data){
				alert("즐겨찾기 추가 성공!");
			}
		});
	}
</script>
<!-- appkey에 카카오 javascript key -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4a3a0c46296d3b6469323a83dab68949"></script>
<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapCenter = new kakao.maps.LatLng( ${map.info.mapy}, ${map.info.mapx} ), // 지도의 중심 좌표
	    mapOption = {
	        center: mapCenter, // 지도의 중심 좌표
	        level: 4 // 지도의 확대 레벨
	    };

		// 지도를 표시할 div와  지도 옵션으로  지도를 생성
		var map = new kakao.maps.Map(mapContainer, mapOption);
	
		// 지도에 올릴 마커를 생성
		var mMarker = new kakao.maps.Marker({
		    position: mapCenter, // 지도의 중심좌표에 올리기.
		    map: map // 생성하면서 지도에 올리기.
		});
	
		// 지도에 올릴 장소명 인포윈도우
		var mLabel = new kakao.maps.InfoWindow({
		    position: mapCenter, // 지도의 중심좌표에 올리기.
		    content: '${map.info.title}' // 인포윈도우 내부에 들어갈 컨텐츠.
		});
		mLabel.open(map, mMarker); // 지도에 올리면서, 두번째 인자로 들어간 마커 위에 올라가도록 설정.
				
		var rvContainer = document.getElementById('roadview'); // 로드뷰를 표시할 div
		var rv = new kakao.maps.Roadview(rvContainer); // 로드뷰 객체 생성
		var rc = new kakao.maps.RoadviewClient(); // 좌표를 통한 로드뷰의 panoid를 추출하기 위한 로드뷰 help객체 생성
		var rvResetValue = {} //로드뷰의 초기화 값을 저장할 변수
		rc.getNearestPanoId(mapCenter, 50, function(panoId) {
		    rv.setPanoId(panoId, mapCenter);//좌표에 근접한 panoId를 통해 로드뷰를 실행.
		    rvResetValue.panoId = panoId;
		});
	
		// 로드뷰 초기화 이벤트
		kakao.maps.event.addListener(rv, 'init', function() {
	
		    // 로드뷰에 올릴 마커를 생성.
		    var rMarker = new kakao.maps.Marker({
		        position: mapCenter,
		        map: rv //map 대신 rv(로드뷰 객체)로 설정하면 로드뷰에 올라감.
		    });
	
		    // 로드뷰에 올릴 장소명 인포윈도우를 생성.
		    var rLabel = new kakao.maps.InfoWindow({
		        position: mapCenter,
		        content: '${map.info.title}'
		    });
		    rLabel.open(rv, rMarker);
	
		    // 로드뷰 마커가 중앙에 오도록 로드뷰의 viewpoint 조정.
		    var projection = rv.getProjection(); // viewpoint(화면좌표)값을 추출할 수 있는 projection 객체를 가져옴.
		    
		    // 마커의 position과 altitude값을 통해 viewpoint값(화면좌표)를 추출.
		    var viewpoint = projection.viewpointFromCoords(rMarker.getPosition(), rMarker.getAltitude());
		    rv.setViewpoint(viewpoint); //로드뷰에 뷰포인트를 설정.
	
		    //각 뷰포인트 값을 초기화를 위해 저장해 놓는다.
		    rvResetValue.pan = viewpoint.pan;
		    rvResetValue.tilt = viewpoint.tilt;
		    rvResetValue.zoom = viewpoint.zoom;
		});
	
		//지도 이동 이벤트 핸들러
		function moveKakaoMap(self){
		    
		    var center = map.getCenter(), 
		        lat = center.getLat(),
		        lng = center.getLng();
	
		    self.href = 'https://map.kakao.com/link/map/' + encodeURIComponent('${map.info.title}') + ',' + lat + ',' + lng; //Kakao 지도로 보내는 링크
		}
	
		//지도 초기화 이벤트 핸들러
		function resetKakaoMap(){
		    map.setCenter(mapCenter); //지도를 초기화 했던 값으로 다시 셋팅.
		    map.setLevel(mapOption.level);
		}
	
		//로드뷰 이동 이벤트 핸들러
		function moveKakaoRoadview(self){
		    var panoId = rv.getPanoId(); //현 로드뷰의 panoId값을 가져옴.
		    var viewpoint = rv.getViewpoint(); //현 로드뷰의 viewpoint(pan,tilt,zoom)값을 가져옴.
		    self.href = 'https://map.kakao.com/?panoid='+panoId+'&pan='+viewpoint.pan+'&tilt='+viewpoint.tilt+'&zoom='+viewpoint.zoom; //Kakao 지도 로드뷰로 보내는 링크
		}
	
		//로드뷰 초기화 이벤트 핸들러
		function resetRoadview(){
		    //초기화를 위해 저장해둔 변수를 통해 로드뷰를 초기상태로 되돌림.
		    rv.setViewpoint({
		        pan: rvResetValue.pan, tilt: rvResetValue.tilt, zoom: rvResetValue.zoom
		    });
		    rv.setPanoId(rvResetValue.panoId);
		}		
	</script>
</html>