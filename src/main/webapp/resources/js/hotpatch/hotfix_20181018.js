WebSquare.uiplugin.gridView.prototype.showTooltip = function(left, top, label, tooltipPositionY) {
    ["WebSquare.uiplugin.eventController.prototype.showTooltip"];
    //  if(this.timeShowTooltip != null){
    //      clearTimeout(this.timeShowTooltip);
    //      this.timeShowTooltip = null;
    //  }
    //  
    //  this.timeShowTooltip = setTimeout(
    //      this.event.bind(this, function(){
    //          if(!this.tooltip){
    //              requires("uiplugin.output")
    //              this.tooltip = new WebSquare.uiplugin.output(this.id + "_tooltip",{
    //                  className : "w2grid_tooltip " + this.options.tooltipClass
    //              });
    //              this.tooltip.writeTo(WebSquare.getBody());
    //              this.tooltip.activate();
    //          }
    //          
    //          this.tooltip.setStyle("display", "block");
    //          this.tooltip.setStyle("left", left + "px");
    //          this.tooltip.setStyle("top", top + "px");
    //          
    //          this.tooltip.render.innerHTML = label;
    //  }), 1);

    if (this.editedCell != null) {
        return;
    }

    var scrollWidth = document.body.scrollWidth;
    var scrollHeight = document.body.scrollHeight;

    if (!this.tooltip) {
        requires("uiplugin.output");
        this.tooltip = new WebSquare.uiplugin.output(this.id + "_tooltip", {
            className: "w2grid_tooltip " + this.options.tooltipClass,
            style: "position:absolute;" + this.options.tooltipStyle
        });
        this.tooltip.parentFrame = this.parentFrame;
        this.tooltip.writeTo(WebSquare.getBody());
        this.tooltip.activate();

        if (this.options.tooltipHide === "click") {
            this.tooltip.render.onclick = function() {
                this.style.display = "none";
            };
        } else {
            this.tooltip.render.onmouseover = function() {
                this.style.display = "none";
            };
        }
    }

    if (this.options.tooltipHide === "click") {
        if (WebSquare.getBody().hasClass("w2drag_activate") == true) {
            this.tooltip.render.onclick = null;
            this.tooltip.render.onmouseover = function() {
                this.style.display = "none";
            };
        } else {
            this.tooltip.render.onclick = function() {
                this.style.display = "none";
            };
            this.tooltip.render.onmouseover = null;
        }
    }

    this.tooltip.setStyle("display", "block");
    this.tooltip.setStyle("left", left + "px");
    this.tooltip.setStyle("top", top + "px");
    WebSquare.style.adjustZIndex(this.uuid, this.tooltip.uuid, "toolTip");
    this.tooltip.render.innerHTML = label;
    WebSquare.event.fireEvent(this, "ontooltipshow");

    var bottom = this.tooltip.render.offsetTop + this.tooltip.render.offsetHeight + 20; //상수 20값 용도?????
    var scrollHeight = document.body.scrollHeight;
    if (WebSquare.BootLoader.fullViewRatio != null) {
        scrollHeight = document.body.clientHeight + Math.abs(document.body.getBoundingClientRect().top);
    }

    //툴팁이 아래로 펼쳐질 공간이 없을 경우 셀의 top에서 툴팁의 height 뺀 값이 top이 됨
    //현재 top은 cell의 bottom이므로 cell의 top을 알기 위해 tooltipPositionY을 인자로 받음
    if (bottom > scrollHeight) {
        /*if(!tooltipPositionY) {
            tooltipPositionY = 0;
        }*/

        var tooltipTop = top - (tooltipPositionY + this.tooltip.render.offsetHeight);
        if (tooltipTop < 0) tooltipTop = 0;
        this.tooltip.setStyle("top", tooltipTop + "px");
    }

    var right = this.tooltip.render.offsetLeft + this.tooltip.render.offsetWidth;
    if (document.body.scrollWidth > scrollWidth) {
        var tooltipLeft = left - (document.body.scrollWidth - scrollWidth);
        if (tooltipLeft < 0) tooltipLeft = 0;
        this.tooltip.setStyle("left", tooltipLeft + "px");
    }

    if (this.options.tooltipDisplayTime > 0) {
        WebSquare.core.setTimer(this.hideTooltip, {
            key: this.id + "_tooltip_hide_timer",
            caller: this,
            delay: this.options.tooltipDisplayTime
        });
    }

};

WebSquare.uiplugin.grid.prototype.showTooltip = WebSquare.uiplugin.gridView.prototype.showTooltip;

WebSquare.uiplugin.itemTable.prototype.handleMouseWheelEvent = function(e) {
    try {
        var scrollTo = null;
        if(e.wheelDelta) {
            scrollTo = (e.wheelDelta * -1);
        } else {
            if(WebSquare.util.isNumber(e.detail)) {
                scrollTo = (e.detail * 50);
            }
        }

        if(scrollTo) {
            WebSquare.event.stopEvent(e);
            if (!WebSquare.util.isMobile()) {
                WebSquare.event.stopPropagation(e)
            }
            this.render.scrollTop = scrollTo + this.render.scrollTop;
        }
    } catch (ex) {
        WebSquare.exception.printStackTrace(ex);
    }
};