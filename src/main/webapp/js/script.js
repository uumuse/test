$(function(){
	var wow = $('#wowslider-container1');
	var effects = ['fade', 'louvers', 'carousel', 'seven', 'book'];
	var effect = 'fade';
	
	if (typeof playType !== 'undefined') {
		playType = parseInt(playType, 10);
	    if (!isNaN(playType) && playType < effects.length && playType >= 0) {
	        effect = effects[playType];
	    }
	}

	wow.height(wow.width());

	var defaultOptions = {
	    effect: effect,
	    prev: "",
	    next: "",
	    duration: 20 * 100,
	    delay: 20 * 100,
	    width: '100%',
	    height: 'auto',
	    autoPlay: true,
	    autoPlayVideo: false,
	    playPause: false,
	    stopOnHover: false,
	    loop: false,
	    bullets: false,
	    caption: false,
	    captionEffect: "fade",
	    controls: false,
	    responsive: 1,
	    fullScreen: false,
	    onBeforeStep: 0,
	    images: 0,
	    gestures: 0
	};

    wow.wowSlider(defaultOptions);

});