console.log("running");

const tl = gsap.timeline({sync: true});

tl.from("#nid",{
    y: -20,
    opacity: 0,
    duration: .2,
    delay: 0.2
})

tl.from("#fid", {
    z: -100,
    opacity: 0,
    duration: .3,
    // rotate: 360
})

tl.from("#fid .ani", {
    z: -100,
    opacity: 0,
    stagger: 0.1,
    // rotate: 180
})
