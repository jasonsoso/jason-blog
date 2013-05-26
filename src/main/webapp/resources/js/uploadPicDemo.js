if (typeof loadMessage == "undefined") {
	loadMessage = successMessage;
	Y.loading = Y.loading || {};
	Y.loading.kill_msg = function() {
	}
}
Y.settings = {};
Y.settings.avatar = {
	init : function(a) {
		this.options = a || {};
		this.bindAvatarTab();
		this.initUploadForm()
	},
	bindAvatarTab : function() {
		var d = $("avatarNav"), e = $("avatarContent"), a = this, b;
		var c = d.getElement("li.active");
		d.addEvent("click", function(j) {
					j.preventDefault();
					var k = $(j.target);
					if (k && k.get("tag") == "a") {
						k = k.getParent("li");
						if (k.hasClass("active")) {
							return
						}
						c.removeClass("active");
						var i = k.get("node"), h = c.get("node");
						var g = e.getElement(".content_" + i);
						var f = e.getElement(".content_" + h);
						if (i == "rec" && !b) {
							b = true;
							a.loadRecAvatar(g)
						}
						f.setStyle("display", "none");
						g.setStyle("display", "block");
						k.addClass("active");
						c = k
					}
				})
	},
	loadRecAvatar : function(a) {
		var b = this;
		new Request.HTML({
					url : "/ajax/avatar-rec",
					method : "get",
					onComplete : function(e, d, f) {
						a.set("html", f);
						Y.settings.avatarSlide.init(a, b.options)
					}
				}).send()
	},
	saveAvatarAjax : function(b) {
		var a = "/avatar/update-avatar";
		new Request.JSON({
					url : a,
					method : "post",
					data : b,
					onSuccess : function(c) {
						Y.loading.kill_msg && Y.loading.kill_msg();
						if (!c.error) {
							successMessage(c.message, 2000);
							reloadDocument(1000)
						} else {
							errorMessage(c.message)
						}
					}
				}).send()
	},
	initUploadForm : function() {
		In.add("imgareaselect-css", {
			path : urlStatic + "/css/settings/imgareaselect-default.$40119.css",
			type : "css"
		});
		In.add("jquery", {
					path : urlStatic + "/js/jquery-1.7.min.js",
					type : "js"
				});
		In.add("imgareaselect", {
					path : urlStatic
							+ "/js/settings/jquery.$40119.imgareaselect",
					type : "js",
					rely : ["imgareaselect-css", "jquery"]
				});
		var d = $("avatarUploadForm");
		var c = d.getElements("[type=file]"), e = d.getElement("[node=msg]"), b = $(d.avatarText);
		c.each(function(f) {
					f.addEvent("change", function() {
								d.fireEvent("submit");
								b.set("value", this.value)
							})
				});
		var a = this;
		ajaxForm.init(d, {
					onRequest : function() {
						var f = d.getElement("input[type=file]");
						if (!/\.(gif|jpg|jpeg|png|GIF|JPG|JPEG|PNG)$/
								.test(f.value)) {
							errorMessage("请上传jpg、jpeg、gif、png格式的图片");
							return false
						}
						loadMessage("图片正在上传，请稍候……");
						return true
					},
					onComplete : function(h) {
						Y.loading.kill_msg && Y.loading.kill_msg();
						if (h.error) {
							e.set("text", h.message);
							e.addClass("c_f50")
						} else {
							var g = a.avatarInfo = h.images[0];
							var f = d.getParent("[node=upload]");
							if (!f.hasClass("i_imgareaselect")) {
								f.addClass("i_imgareaselect");
								a.showImgAreaSelect(d)
							}
							var i = $("avatarSelect");
							i.set("src", g.path);
							a.initImg(i, g)
						}
					}
				});
		$("uploadSubmit").addEvent("click", a.uploadSubmit.bind(a));
		$("uploadReset").addEvent("click", a.uploadReset.bind(a))
	},
	showImgAreaSelect : function(b) {
		var a = b.getElement("[type=file]");
		a.dispose()
	},
	initImg : function(d, g) {
		var h = 300, c = 180;
		var j = this;
		var e = this.fixImg(d, g, h);
		var b = Math.round((e.width - c) / 2), i = Math.round((e.height - c)
				/ 2), a = b + c, f = i + c;
		this.selection = {
			x1 : b,
			y1 : i,
			x2 : a,
			y2 : f,
			width : c,
			height : c
		};
		this.fixPreviewImg(this.selection, g);
		In("imgareaselect", function() {
					jQuery.noConflict();
					if (j.imgAreaSelect) {
						j.imgAreaSelect.setSelection(b, i, a, f)
					} else {
						j.imgAreaSelect
								|| jQuery("#avatarSelect").imgAreaSelect({
											aspectRatio : "1:1",
											handles : "corners",
											x1 : b,
											y1 : i,
											x2 : a,
											y2 : f,
											parent : jQuery("#avatarSelectBox"),
											onSelectChange : j.previewImg
													.bind(j),
											onSelectEnd : j.selectEnd.bind(j)
										})
					}
				})
	},
	fixImg : function(e, f, b) {
		var d = f.width, a = f.height;
		var c = Math.max(d, a);
		this.scale = b / c;
		this.width = Math.round(d * this.scale);
		this.height = Math.round(a * this.scale);
		var h = this.width < b ? Math.round((b - this.width) / 2) : 0;
		var g = this.height < b ? Math.round((b - this.height) / 2) : 0;
		e.setStyles({
					width : this.width,
					height : this.height,
					top : g,
					left : h
				});
		return {
			width : this.width,
			height : this.height,
			left : h,
			top : g
		}
	},
	fixPreviewImg : function(c, b) {
		var a = $("avatarPreview");
		this.hugeImg = (this.hugeImg || a.getElement(".avatar_huge")).set(
				"src", b.path);
		this.bigImg = (this.bigImg || a.getElement(".avatar_big")).set("src",
				b.path);
		this.midImg = (this.midImg || a.getElement(".avatar_mid")).set("src",
				b.path);
		this.smallImg = (this.smallImg || a.getElement(".avatar_small")).set(
				"src", b.path);
		this.previewImg(null, c)
	},
	previewImg : function(a, b) {
		if (!b.width || !b.height) {
			return
		}
		this.renderPreviewImg(this.hugeImg, 180, b);
		this.renderPreviewImg(this.bigImg, 100, b);
		this.renderPreviewImg(this.midImg, 50, b);
		this.renderPreviewImg(this.smallImg, 20, b)
	},
	renderPreviewImg : function(a, b, c) {
		var e = (b / c.width) * this.scale;
		var d = {
			width : Math.round(e * (this.width / this.scale)),
			height : Math.round(e * (this.height / this.scale)),
			x1 : Math.round(e * (c.x1 / this.scale)),
			y1 : Math.round(e * (c.y1 / this.scale))
		};
		if (b == 180) {
			this.clip = d
		}
		a.setStyles({
					width : d.width,
					height : d.height,
					"margin-left" : -d.x1,
					"margin-top" : -d.y1
				})
	},
	selectEnd : function(a, b) {
		this.selection = b
	},
	uploadSubmit : function() {
		loadMessage("图片正在保存，请稍候……");
		var a = this.getImgPara2();
		new Request.JSONP({
			url : "http://image.yinyuetai.com/edit",
			data : "redirect=http://www.yinyuetai.com/avatar/update-avatar?avatarType=uploadAvatar&cmd="
					+ encodeURIComponent(JSON.encode(a)),
			callbackKey : "callback",
			onComplete : function(b) {
				Y.loading.kill_msg && Y.loading.kill_msg();
				if (!b.error) {
					successMessage(b.message, 2000);
					reloadDocument(2000)
				} else {
					errorMessage(b.message)
				}
			}
		}).send()
	},
	getImgPara2 : function() {
		var b = this.clip.x1, d = this.clip.y1;
		b = b >= 0 ? "+" + b : b;
		d = d >= 0 ? "+" + d : d;
		var c = this.clip.width, a = this.clip.height;
		return [{
					sizes : c + "x" + a,
					srcImg : this.avatarInfo.path,
					op : "scale"
				}, {
					point : b + d,
					op : "crop",
					size : "180x180"
				}, {
					sizes : "180x180,100x100,50x50,20x20",
					op : "scale"
				}, {
					saveOriginal : 0,
					op : "save",
					plan : "avatar",
					belongId : userId || (Y.user && Y.user.userId)
				}]
	},
	getImgPara : function() {
		var b = this.clip.x1, d = this.clip.y1;
		var c = this.clip.width, a = this.clip.height;
		return c + "," + a + "," + b + "," + d + "," + 180 + "," + 180
	},
	uploadReset : function() {
		reloadDocument(1)
	}
};
Y.settings.avatarSlide = {
	index : 1,
	cache : {},
	init : function(a, b) {
		this.options = Object.merge({
					pageSize : 15,
					maxPage : 3,
					itemWidth : 580,
					selectCallback : function(d, c) {
						var e = d.get("data-id");
						Y.settings.avatar
								.saveAvatarAjax("avatarType=systemAvatar&avatarImgId="
										+ e)
					}
				}, b);
		this.slider = a.getElement(".slider");
		this.slider.setStyle("width", this.options.itemWidth
						* this.options.maxPage + "px");
		this.left = a.getElement(".left_green");
		this.right = a.getElement(".right_green");
		this.bindEvent()
	},
	bindEvent : function() {
		var a = this;
		this.left.addEvent("click", function(b) {
					b.preventDefault();
					if (a.index <= 1) {
						return
					}
					a.index--;
					a.tween();
					a.checkArrowState()
				});
		this.right.addEvent("click", function(b) {
					b.preventDefault();
					if (a.index >= a.options.maxPage) {
						return
					}
					a.index++;
					a.tween();
					a.getImg();
					a.checkArrowState()
				});
		this.slider.addEvent("click", function(b) {
					b.preventDefault();
					var c = $(b.target);
					if (c && (c.get("tag") == "img" || c.get("tag") == "a")) {
						c = c.getParent("li");
						a.options.selectCallback(c, a.slider)
					}
				})
	},
	checkArrowState : function() {
		if (this.index == 1) {
			this.left.addClass("left_gray")
		} else {
			this.left.removeClass("left_gray")
		}
		if (this.index == this.options.maxPage) {
			this.right.addClass("right_gray")
		} else {
			this.right.removeClass("right_gray")
		}
	},
	getImg : function() {
		if (this.cache[this.index]) {
			return
		}
		this.cache[this.index] = true;
		var a = this.options.pageSize, d = (this.index - 1) * a + 1;
		var c = "";
		for (var b = d; b < d + a; b++) {
			c += '<li data-id="'
					+ b
					+ '"><a href="#"><img width="100" height="100" src="http://img2.yytcdn.com/uploads/default/persons/header'
					+ b + '_100x100.jpg"/></a></li>'
		}
		new Element("ul", {
					html : c
				}).inject(this.slider)
	},
	tween : function() {
		this.fx = this.fx || new Fx.Tween(this.slider);
		this.fx.cancel().start("margin-left",
				-1 * (this.index - 1) * this.options.itemWidth + "px")
	}
};