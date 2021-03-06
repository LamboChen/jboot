/**
 * Copyright (c) 2016-2020, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jboot.support.sentinel;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import io.jboot.web.fixedinterceptor.FixedInterceptor;

/**
 * @author michael yang (fuhai999@gmail.com)
 * @Date: 2020/1/7
 */
public class SentinelInterceptor implements Interceptor, FixedInterceptor {


    @Override
    public void intercept(Invocation inv) {
        SentinelProcesser processer = SentinelManager.me().getProcesser();
        if (processer != null){
            processer.doProcess(inv);
        }else {
            inv.invoke();
        }
    }


}
