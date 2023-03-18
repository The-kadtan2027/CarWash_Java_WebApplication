<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
			import="com.cw.dto.BookingsBean"
%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Payment method</title>
        <link rel="stylesheet" href="stylePayment.css">
    </head>

    <body>
    <%
   		BookingsBean booking = (BookingsBean)session.getAttribute("payment");
    	/* Float amount = (Float)request.getAttribute("amount");
    	String bookingId = (String)request.getAttribute("bookingid"); */
    	
    	
    %>
        <div class="screen flex-center">
            <form class="popup flex p-lg" action="payment" method="post">
                <div class="close-btn pointer flex-center p-sm">
                    <i class="ai-cross"></i>
                </div>

                <!-- CARD FORM -->
                <div class="flex-fill flex-vertical">
                    <div class="header flex-between flex-vertical-center">
                        <div class="flex-vertical-center">
                            <i class="ai-bitcoin-fill size-xl pr-sm f-main-color"></i>
                            <span class="title">
                                <strong>Online</strong><span>Pay</span>
                            </span>
                        </div>
                        <div class="timer" data-id="timer">
                            <span>0</span><span>5</span>
                            <em>:</em>
                            <span>0</span><span>0</span>
                        </div>
                    </div>
                    <div class="card-data flex-fill flex-vertical">

                        <!-- Card Number -->
                        <div class="flex-between flex-vertical-center">
                            <div class="card-property-title">
                                <strong>Card Number</strong>
                                <span>Enter 16-digit card number on the card</span>
                            </div>
                            <div class="f-main-color pointer"><i class="ai-pencil"></i> Edit</div>
                        </div>

                        <!-- Card Field -->
                        <div class="flex-between">
                            <div class="card-number flex-vertical-center flex-fill">
                                <div class="card-number-field flex-vertical-center flex-fill">


                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="24px"
                                        height="24px">
                                        <path fill="#ff9800" d="M32 10A14 14 0 1 0 32 38A14 14 0 1 0 32 10Z" />
                                        <path fill="#d50000" d="M16 10A14 14 0 1 0 16 38A14 14 0 1 0 16 10Z" />
                                        <path fill="#ff3d00"
                                            d="M18,24c0,4.755,2.376,8.95,6,11.48c3.624-2.53,6-6.725,6-11.48s-2.376-8.95-6-11.48 C20.376,15.05,18,19.245,18,24z" />
                                    </svg>



                           
                                    <input class="numbers" name="card-number" type="number" min="1" max="9999" placeholder="0000">-
                                    <input class="numbers" name="card-number" type="number" placeholder="0000">-
                                    <input class="numbers" name="card-number" type="number" placeholder="0000">-
                                    <input class="numbers" name="card-number" type="number" placeholder="0000" data-bound="carddigits_mock"
                                        data-def="0000">
                                </div>
                                <i class="ai-circle-check-fill size-lg f-main-color"></i>
                            </div>
                        </div>

                        <!-- Expiry Date -->
                        <div class="flex-between">
                            <div class="card-property-title">
                                <strong>Expiry Date</strong>
                                <span>Enter the expiration date of the card</span>
                            </div>
                            <div class="card-property-value flex-vertical-center">
                                <div class="input-container half-width">
                                    <input class="numbers" data-bound="mm_mock" data-def="00" type="number" min="1"
                                        max="12" step="1" placeholder="MM">
                                </div>
                                <span class="m-md">/</span>
                                <div class="input-container half-width">
                                    <input class="numbers" name="expiry-date" data-bound="yy_mock" data-def="01" type="number" min="23"
                                        max="99" step="1" placeholder="YY">
                                </div>
                            </div>
                        </div>

                        <!-- CCV Number -->
                        <div class="flex-between">
                            <div class="card-property-title">
                                <strong>CVC Number</strong>
                                <span>Enter card verification code from the back of the card</span>
                            </div>
                            <div class="card-property-value">
                                <div class="input-container">
                                    <input id="cvc" name="cvv-number" type="password">
                                    <i id="cvc_toggler" data-target="cvc" class="ai-eye-open pointer"></i>
                                </div>
                            </div>
                        </div>

                        <!-- Name -->
                        <div class="flex-between">
                            <div class="card-property-title">
                                <strong>Cardholder Name</strong>
                                <span>Enter cardholder's name</span>
                            </div>
                            <div class="card-property-value">
                                <div class="input-container">
                                    <input id="name" name="name" data-bound="name_mock" data-def="Mr. Cardholder" type="text"
                                        class="uppercase" placeholder="CARDHOLDER NAME">
                                    <i class="ai-person"></i>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="action flex-center">
                        <button type="submit" class="b-main-color pointer">Pay Now</button>
                    </div>
                </div>
			
                <!-- SIDEBAR -->
                <div class="sidebar flex-vertical">
                    <div>

                    </div>
                    <div class="purchase-section flex-fill flex-vertical">

                        <div class="card-mockup flex-vertical">
                            <div class="flex-fill flex-between">
                                <i class="ai-bitcoin-fill size-xl f-secondary-color"></i>
                                <i class="ai-wifi size-lg f-secondary-color"></i>
                            </div>
                         <div>
                             <div id="name_mock" class="size-md pb-sm uppercase ellipsis">mr. Cardholder</div>
                                <div class="size-md pb-md">
                                    <strong>
                                        <span class="pr-sm">
                                            &#x2022;&#x2022;&#x2022;&#x2022;
                                        </span>
                                        <span id="carddigits_mock">0000</span>
                                    </strong>
                                </div>
                                <div class="flex-between flex-vertical-center">
                                    <strong class="size-md">
                                        <span id="mm_mock">00</span>/<span id="yy_mock">01</span>
                                    </strong>

                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="24px"
                                        height="24px">
                                        <path fill="#ff9800" d="M32 10A14 14 0 1 0 32 38A14 14 0 1 0 32 10Z" />
                                        <path fill="#d50000" d="M16 10A14 14 0 1 0 16 38A14 14 0 1 0 16 10Z" />
                                        <path fill="#ff3d00"
                                            d="M18,24c0,4.755,2.376,8.95,6,11.48c3.624-2.53,6-6.725,6-11.48s-2.376-8.95-6-11.48 C20.376,15.05,18,19.245,18,24z" />
                                    </svg>

                                    <!--
                      <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 48 48" width="24px" height="24px"><path fill="#1565C0" d="M45,35c0,2.209-1.791,4-4,4H7c-2.209,0-4-1.791-4-4V13c0-2.209,1.791-4,4-4h34c2.209,0,4,1.791,4,4V35z"/><path fill="#FFF" d="M15.186 19l-2.626 7.832c0 0-.667-3.313-.733-3.729-1.495-3.411-3.701-3.221-3.701-3.221L10.726 30v-.002h3.161L18.258 19H15.186zM17.689 30L20.56 30 22.296 19 19.389 19zM38.008 19h-3.021l-4.71 11h2.852l.588-1.571h3.596L37.619 30h2.613L38.008 19zM34.513 26.328l1.563-4.157.818 4.157H34.513zM26.369 22.206c0-.606.498-1.057 1.926-1.057.928 0 1.991.674 1.991.674l.466-2.309c0 0-1.358-.515-2.691-.515-3.019 0-4.576 1.444-4.576 3.272 0 3.306 3.979 2.853 3.979 4.551 0 .291-.231.964-1.888.964-1.662 0-2.759-.609-2.759-.609l-.495 2.216c0 0 1.063.606 3.117.606 2.059 0 4.915-1.54 4.915-3.752C30.354 23.586 26.369 23.394 26.369 22.206z"/><path fill="#FFC107" d="M12.212,24.945l-0.966-4.748c0,0-0.437-1.029-1.573-1.029c-1.136,0-4.44,0-4.44,0S10.894,20.84,12.212,24.945z"/></svg>
                      -->

                                </div>
                            </div>
                        </div>

                        <ul class="purchase-props">
                          <!--   <li class="flex-between">
                                <span>Company</span>
                                <strong>Apple</strong>
                            </li> -->
                            <li class="flex-between">
                                <span>Booking ID</span>
                                <strong><%=booking.bId() %></strong>
                            </li>
                            <!-- <li class="flex-between">
                                <span>Product</span>
                                <strong>MacBook Air</strong>
                            </li>
                            <li class="flex-between">
                                <span>VAT (20%)</span>
                                <strong>$100.00</strong>
                            </li> -->
                        </ul>
                    </div>
                    <div class="separation-line"></div>
                    <div class="total-section flex-between flex-vertical-center">
                        <div class="flex-fill flex-vertical">
                            <div class="total-label f-secondary-color">You have to Pay</div>
                            <div>
                                <strong><%= (int)booking.amount() %></strong>
                                <small>.00 <span class="f-secondary-color">Rs</span></small>
                                <input type="hidden" name="amount" value="<%= booking.amount() %>" >
                            </div>
                        </div>
                        <i class="ai-coin size-lg"></i>
                    </div>
                </div>
                </form>
        </div>

        <script>

            /* COPY INPUT VALUES TO CARD MOCKUP */
            const bounds = document.querySelectorAll('[data-bound]');

            for (let i = 0; i < bounds.length; i++) {
                const targetId = bounds[i].getAttribute('data-bound');
                const defValue = bounds[i].getAttribute('data-def');
                const targetEl = document.getElementById(targetId);
                bounds[i].addEventListener('keyup', () => targetEl.innerText = bounds[i].value || defValue);
            }


            /* TOGGLE CVC DISPLAY MODE */
            const cvc_toggler = document.getElementById('cvc_toggler');

            cvc_toggler.addEventListener('click', () => {
                const target = cvc_toggler.getAttribute('data-target');
                const el = document.getElementById(target);
                el.setAttribute('type', el.type === 'text' ? 'password' : 'text');
            });


            /* TIMER COUNTDOWN */
            const timer = document.querySelector('[data-id=timer]');
            let timeLeft = 5 * 60 + 1;

            const tick = () => {
                if (timeLeft > 0) {
                    timeLeft--;
                    const date = new Date('2000-01-01 00:00:00');
                    date.setSeconds(timeLeft);
                    const str = date.toISOString();
                    timer.children[0].innerText = str[14];
                    timer.children[1].innerText = str[15];
                    timer.children[3].innerText = str[17];
                    timer.children[4].innerText = str[18];
                }
            }

            setInterval(() => { tick(); }, 1000);
            tick();

        </script>

    </body>

    </html>