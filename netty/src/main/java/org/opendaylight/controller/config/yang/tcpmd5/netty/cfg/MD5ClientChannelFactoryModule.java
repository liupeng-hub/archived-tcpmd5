/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.config.yang.tcpmd5.netty.cfg;

import org.opendaylight.tcpmd5.api.KeyAccessFactory;
import org.opendaylight.tcpmd5.netty.MD5NioSocketChannelFactory;

/**
 * Service representing a way for accessing key informtion.
 */
public class MD5ClientChannelFactoryModule extends
        org.opendaylight.controller.config.yang.tcpmd5.netty.cfg.AbstractMD5ClientChannelFactoryModule {
    public MD5ClientChannelFactoryModule(final org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public MD5ClientChannelFactoryModule(final org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver,
            final org.opendaylight.controller.config.yang.tcpmd5.netty.cfg.MD5ClientChannelFactoryModule oldModule,
            final java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        final class AutoCloseableMD5NioSocketChannelFactory extends MD5NioSocketChannelFactory implements AutoCloseable {
            public AutoCloseableMD5NioSocketChannelFactory(final KeyAccessFactory keyAccessFactory) {
                super(keyAccessFactory);
            }

            @Override
            public void close() {
                // Noop
            }
        }

        return new AutoCloseableMD5NioSocketChannelFactory(getKeyAccessFactoryDependency());
    }

}
