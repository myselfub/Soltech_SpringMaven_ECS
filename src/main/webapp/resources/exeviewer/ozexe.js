
var OZUtil = {


    OZEXEViewerRun: function(namespace, param,sep,failCB)
    {
        
        //var ii = document.getElementById("tt");

        var encodeStr = OZUtil.encode(param);
        
        
        var url = "";
        
      
        var strParam = "ozrv-" + namespace + "://direct/" + sep + "/"+encodeStr;  
        
        OZUtil.protocolCheck(strParam,function () {
         
                failCB && failCB();
        
            });
            

        
    },
    _keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",


    encode: function(input) {
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;

        input = OZUtil._utf8_encode(input);

        while (i < input.length) {

            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);

            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;

            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }

            output = output + this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) + this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);

        }

        return output;
    },


    

    _utf8_encode: function(string) {

        var utftext = "";

        for (var n = 0; n < string.length; n++) {

            var c = string.charCodeAt(n);

            if (c < 128) {
                utftext += String.fromCharCode(c);
            }
            else if ((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            }
            else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }

        }

        return utftext;
    },
    
    _registerEvent: function (target, eventType, cb) {
        if (target.addEventListener) {
            target.addEventListener(eventType, cb);
            return {
                remove: function () {
                    target.removeEventListener(eventType, cb);
                }
            };
        } else {
            target.attachEvent(eventType, cb);
            return {
                remove: function () {
                    target.detachEvent(eventType, cb);
                }
            };
        }
    },

    _createHiddenIframe: function (target, uri) {
        var iframe = document.createElement("iframe");
        iframe.src = uri;
        iframe.id = "hiddenIframe";
        iframe.style.display = "none";
        target.appendChild(iframe);
        return iframe;
    },

    openUriWithHiddenFrame: function (uri, failCb) {

        var timeout = setTimeout(function () {
            failCb();
            handler.remove();
        }, 4000);

        var iframe = document.querySelector("#hiddenIframe");
        if (!iframe) {
            iframe = OZUtil._createHiddenIframe(document.body, "about:blank");
        }

        var handler = OZUtil._registerEvent(window, "blur", onBlur);

        function onBlur() {
            clearTimeout(timeout);
            handler.remove();
        }

        iframe.contentWindow.location.href = uri;
    },

    openUriWithTimeoutHack: function (uri, failCb) {

        var timeout = setTimeout(function () {
            failCb();
            handler.remove();
        }, 4000);

        //handle page running in an iframe (blur must be registered with top level window)
        var target = window;
        while (target != target.parent) {
            target = target.parent;
        }

        var handler = OZUtil._registerEvent(target, "blur", onBlur);

        function onBlur() {
        
              failCb();
            clearTimeout(timeout);
            handler.remove();
        }

        window.location = uri;
        
    },
    
    openUri: function (uri) {

        //handle page running in an iframe (blur must be registered with top level window)
        var target = window;
        while (target != target.parent) {
            target = target.parent;
        }

        
        window.location = uri;

    },

    openUriUsingFirefox: function (uri, failCb) {
        var iframe = document.querySelector("#hiddenIframe");
        if (!iframe) {
            iframe = OZUtil._createHiddenIframe(document.body, "about:blank");
        }
        try {
            iframe.contentWindow.location.href = uri;
        } catch (e) {
            if (e.name == "NS_ERROR_UNKNOWN_PROTOCOL") {
                failCb();
            }
        }
    },

    openUriUsingIEInOlderWindows : function (uri, failCb) {
        if (OZUtil.getInternetExplorerVersion() === 10) {
            OZUtil.openUriUsingIE10InWindows7(uri, failCb);
        } else if (OZUtil.getInternetExplorerVersion() === 9 || OZUtil.getInternetExplorerVersion() === 11) {
            OZUtil.openUriWithHiddenFrame(uri, failCb);
        } else {
            
            OZUtil.openUriInNewWindowHack(uri, failCb);
        }
    },

    openUriUsingIE10InWindows7 : function (uri, failCb) {
        var timeout = setTimeout(failCb, 4000);
        window.addEventListener("blur", function () {
            clearTimeout(timeout);
        });

        var iframe = document.querySelector("#hiddenIframe");
        if (!iframe) {
            iframe = OZUtil._createHiddenIframe(document.body, "about:blank");
        }
        try {
            iframe.contentWindow.location.href = uri;
        } catch (e) {
            failCb();
            clearTimeout(timeout);
        }
    },

    openUriInNewWindowHack: function (uri, failCb) {
        var myWindow = window.open('', '', 'width=0,height=0');

        myWindow.document.write("<iframe src='" + uri + "'></iframe>");
        setTimeout(function () {
            try {
                myWindow.location.href;
                myWindow.setTimeout("window.close()", 4000);
            } catch (e) {
                myWindow.close();
                failCb();
            }
        }, 2000);
    },

    openUriWithMsLaunchUri: function (uri, failCb) {
        navigator.msLaunchUri(uri,
            function () {
            },
            failCb
            );
    },

    checkBrowser: function () {
        var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
        return {
            isOpera: isOpera,
            isFirefox: typeof InstallTrigger !== 'undefined',
            isSafari: Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0,
            isChrome: !!window.chrome && !isOpera,
            isIE: /*@cc_on!@*/false || !!document.documentMode   // At least IE6
        }
    },

   getInternetExplorerVersion:  function () {
        var rv = -1;
        if (navigator.appName === "Microsoft Internet Explorer") {
            var ua = navigator.userAgent;
            var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
            if (re.exec(ua) != null)
                rv = parseFloat(RegExp.$1);
        }
        else if (navigator.appName === "Netscape") {
            var ua = navigator.userAgent;
            var re = new RegExp("Trident/.*rv:([0-9]{1,}[\.0-9]{0,})");
            if (re.exec(ua) != null) {
                rv = parseFloat(RegExp.$1);
            }
        }
        return rv;
    },

    protocolCheck: function (uri, failCb) {
        function failCallback() {
            failCb && failCb();
        }
      

        if (navigator.msLaunchUri) { //for IE and Edge in Win 8 and Win 10
            OZUtil.openUriUsingIEInOlderWindows(uri, failCallback);
        } else {
            var browser = OZUtil.checkBrowser();
            
            if (browser.isFirefox) {
                  
                OZUtil.openUriUsingFirefox(uri, failCallback);
            } else if (browser.isChrome) {
                      
                OZUtil.openUriWithTimeoutHack(uri, failCallback);
            } else if (browser.isIE) {
                  
                OZUtil.openUriUsingIEInOlderWindows(uri, failCallback);
            } 
            
            else {
              
              OZUtil.openUri(uri);
                //not supported, implement please
            }
        }
    }
}