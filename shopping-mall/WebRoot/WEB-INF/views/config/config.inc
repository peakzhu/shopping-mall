<script type="text/javascript" charset="utf-8">
    var C = C || {};
	(function(C)
	{
		C.default_pageSize = 20;
		C.USERNAME = "${data.user.nickName}"
		C.USERTYPE="${data.user.userType}"
		C.SID = "${data.user.identify}";
		C.UID = "${data.user.userId}";
		C.ROLEID = "${data.user.curRoleId}";
		C.ROLES = ${data.roles};
		C.POWER = ${data.powers};
		C.POWEROPERATE = ${data.powerOperates};
		C.CURPOWER = "";
	})(C);
</script>