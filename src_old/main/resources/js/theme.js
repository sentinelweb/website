(function ($) {

	"use strict";

	// Page Transitions
	$(window).on('load', function () {
		var $body = $('body');
		var fadeLink = 'a:not([target="_blank"]):not([href^="#"]):not([href^="mailto"]):not([class*="no-redirect"]):not([class*="lightbox-link"])';
		$body.addClass('page-loaded');
		Appear.init();
		$body.on('click', fadeLink, function (e) {
			if ( e['altKey'] || e['ctrlKey'] || e['shiftKey'] || e['metaKey'] ) return;
			e.preventDefault();
			var link = this.href;
			$('#preloader').one('transitionend webkitTransitionEnd oTransitionEnd', function () {
				window.location = link;
			});
			$body.removeClass('page-loaded');
		});
	});

	// Prevent loading from cache
	window.onpageshow = function (e) {
		if(e.persisted) window.location.reload();
	}

	// NEW: onepage
	if (document.querySelector('nav.onepage')) {
		new ScrollListener('nav.onepage a', {
			navigation: true
		});
	}

	// Parallax Portfolio Captions
	document.querySelectorAll('.parallax-folio-item figcaption').forEach(function (caption) {
		new ScrollListener(caption, {		
			onAppear: function () {
				this.classList.add('visible');
			},
			offsetBottom: 200,
			offsetTop: 200
		});
	});

	// Mob Menu Button
	$('#header').on('click', '.mob-menu', function(e) {
		e.preventDefault();
		$('.mob-menu').toggleClass('active');
		$('.navigation').slideToggle();
	});

	// Mob Menu Dropdown
	$('#header').on('click', 'a', function(e) {
		if(window.innerWidth>1024) return;
		var submenu = $(this).next('ul, .mega-menu');
		if(submenu.length) {		
			e.preventDefault();
			submenu.slideToggle();
		}
	});

	// onepage navigation
	$('.navigation.onepage').on('click', 'a', function(){
		$('.mob-menu.active').click();
	});

	// Scroll down line
	var sd = document.querySelector('.scroll-down');
	if(sd){	
		sd.addEventListener('click', function(e) {
			e.preventDefault();
			var hero = document.querySelector('.hero-fullscreen') || document.querySelector('section');
			var st = hero ? hero.getBoundingClientRect().bottom : window.innerHeight;
			$('html, body').animate({scrollTop: st}, 1000, 'easeInOutExpo');
		});
		raf('scroll', function () {
			if(!window.pageYOffset){
				sd.classList.remove('scrolled');
			}else{
				sd.classList.add('scrolled');
			}
		});
	}

	// Hover List
	document.querySelectorAll('.hover-list-links').forEach(function (links) {
		document.body.classList.add('has-hover-list');
		links.querySelectorAll('.item').forEach(function (item, index) {
			$(item).on('mouseenter touchstart', function () {
				document.body.classList.add('hover-item-active', 'hover-links-active');
				document.querySelector('.hover-list-media').swiper.slideTo(index);
			});
		});
		$(links).on('mouseleave mouseout', function () {
			document.body.classList.remove('hover-links-active');
		});
	});

	// Entrance Page
	if( document.querySelector('.entrance') ) {
		document.body.classList.add('has-entrance');
	}

	// Portfolio With Background Blur
	var bgBlur = document.querySelector('.background-scroll-blur');
	if (bgBlur) {
		var cl = bgBlur.classList, cln = 'blurred';
		window.raf('scroll', function () {
			window.pageYOffset > 50 ? cl.add(cln) : cl.remove(cln);
		});
	}

	// Hero sizing JS fallback
	// cache
	var pt = $('.sticky-header #main, .fixed-header #main');
	var pb = $('.sticky-header.sticky-footer #main, .fixed-header.fixed-footer #main');
	var hf = $('.hero-fullscreen');
	var hfs = $('.sticky-header.sticky-footer .hero-fullscreen, .fixed-header.fixed-footer .hero-fullscreen');
	var hmf = $('.hero-min-fullscreen');
	var hmfs = $('.sticky-header.sticky-footer .hero-min-fullscreen, .fixed-header.fixed-footer .hero-min-fullscreen');
	// resize
	function heroSize() {
		var wh = $(window).height();
		var hh = $('#header').outerHeight() || 0;
		var fh = $('#footer').outerHeight() || 0;
		pt.css('padding-top', hh);
		pb.css('padding-bottom', fh);
		hf.css('height', (wh-hh) );
		hfs.css('height', (wh-hh-fh) );
		hmf.css('min-height', (wh-hh) );
		hmfs.css('min-height', (wh-hh-fh) );
	}
	heroSize();
	window.addEventListener('resize', heroSize);

})(jQuery);



